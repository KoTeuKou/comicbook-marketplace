import React, {Component} from 'react';
import {ButtonGroup, Container, Table} from 'reactstrap';
import AppNavbar from '../App/AppNavbar';
import {Link} from 'react-router-dom';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faEye, faPencilAlt} from '@fortawesome/fontawesome-free-solid'

class UserList extends Component {

    constructor(props) {
        super(props);
        this.state = {users: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/user')
            .then(response => response.json())
            .then(data => this.setState({users: data}));
    }

    async remove(id) {
        await fetch(`/user/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedUsers = [...this.state.users].filter(i => i.id !== id);
            this.setState({users: updatedUsers});
        });
    }

    render() {
        const {users, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const userList = users.map(user => {
            return <tr key={user.id}>
                <td>
                    <Link to={"/user/" + user.id}>
                        <img src={user.imagePath ? user.imagePath :
                            'https://avatars.mds.yandex.net/get-pdb/2834774/717f6bd2-d0f6-4cda-a493-bf23e49d5792/s1200'}
                             width="200px" alt="NANI?!"/>
                    </Link>
                </td>
                <td style={{whiteSpace: 'nowrap'}}>{user.firstName}</td>
                <td>{user.lastName}</td>
                <td>{user.city}</td>
                <td>{user.country}</td>
                <td>
                    <ButtonGroup>
                        <div style={{
                            backgroundColor: 'lightcyan', borderRadius: '5px', padding: '5px', maxWidth: '55%'
                        }}>
                            <Link className={faEye} to={"/user/" + user.id}>
                                <FontAwesomeIcon icon={faEye}/>
                                <span>View</span>
                            </Link>
                        </div>
                        <div style={{
                            backgroundColor: 'lightyellow', borderRadius: '5px', padding: '5px', maxWidth: '55%'
                        }}>
                            <Link to="/">
                                <FontAwesomeIcon icon={faPencilAlt}/>
                                <span>Write message</span>
                            </Link>
                        </div>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <h3>Users</h3>
                    <div className="table-responsive">
                        <Table className="mt-4">
                            <thead>
                            <tr>
                                <th/>
                                <th width="30%">Name</th>
                                <th width="30%">Surname</th>
                                <th width="20%">City</th>
                                <th width="20%">Country</th>
                                <th width="5%"/>
                            </tr>
                            </thead>
                            <tbody>
                            {userList}
                            </tbody>
                        </Table>
                    </div>
                </Container>
            </div>
        );
    }
}

export default UserList;