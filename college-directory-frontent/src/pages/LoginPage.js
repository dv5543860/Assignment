import React, { useState } from 'react';
import UserService from '../services/UserService';

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('STUDENT');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await UserService.login(username, password, role);
            console.log(response.data);
            // Redirect based on role
            if (role === 'STUDENT') {
                window.location.href = '/student-dashboard';
            } else if (role === 'FACULTY_MEMBER') {
                window.location.href = '/faculty-dashboard';
            } else if (role === 'ADMINISTRATOR') {
                window.location.href = '/admin-dashboard';
            }
        } catch (error) {
            console.error('Login failed', error);
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Username:</label>
                    <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} required />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                <div>
                    <label>Role:</label>
                    <select value={role} onChange={(e) => setRole(e.target.value)}>
                        <option value="STUDENT">Student</option>
                        <option value="FACULTY_MEMBER">Faculty Member</option>
                        <option value="ADMINISTRATOR">Administrator</option>
                    </select>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default LoginPage;
