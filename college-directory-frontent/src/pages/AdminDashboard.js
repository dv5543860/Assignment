import React, { useEffect, useState } from 'react';
import UserService from '../services/UserService';

const AdminDashboard = () => {
    const [adminProfile, setAdminProfile] = useState(null);

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const response = await UserService.getAdminProfile();
                setAdminProfile(response.data);
            } catch (error) {
                console.error('Error fetching admin profile', error);
            }
        };

        fetchProfile();
    }, []);

    if (!adminProfile) return <div>Loading...</div>;

    return (
        <div>
            <h2>Admin Dashboard</h2>
            <div>
                <img src={adminProfile.photo} alt="Profile" />
                <p>Name: {adminProfile.user.name}</p>
                <p>Email: {adminProfile.user.email}</p>
                <p>Phone: {adminProfile.user.phone}</p>
                <p>Department: {adminProfile.department.name}</p>
            </div>
            {/* Other admin-specific features like managing student and faculty records, etc. */}
        </div>
    );
};

export default AdminDashboard;
