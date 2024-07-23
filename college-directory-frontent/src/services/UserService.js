import axios from 'axios';

const API_URL = 'http://localhost:8080/api/';

class UserService {
    login(username, password, role) {
        return axios.post(API_URL + 'auth/login', {
            username,
            password,
            role
        });
    }

    getStudentProfile() {
        return axios.get(API_URL + 'students/profile', {
            headers: { Authorization: 'Bearer ' + localStorage.getItem('token') }
        });
    }

    getFacultyProfile() {
        return axios.get(API_URL + 'faculty/profile', {
            headers: { Authorization: 'Bearer ' + localStorage.getItem('token') }
        });
    }

    getAdminProfile() {
        return axios.get(API_URL + 'admin/profile', {
            headers: { Authorization: 'Bearer ' + localStorage.getItem('token') }
        });
    }
}

export default new UserService();
