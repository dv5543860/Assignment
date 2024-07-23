import React, { useEffect, useState } from 'react';
import UserService from '../services/UserService';

const FacultyDashboard = () => {
    const [facultyProfile, setFacultyProfile] = useState(null);

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const response = await UserService.getFacultyProfile();
                setFacultyProfile(response.data);
            } catch (error) {
                console.error('Error fetching faculty profile', error);
            }
        };

        fetchProfile();
    }, []);

    if (!facultyProfile) return <div>Loading...</div>;

    return (
        <div>
            <h2>Faculty Dashboard</h2>
            <div>
                <img src={facultyProfile.photo} alt="Profile" />
                <p>Name: {facultyProfile.user.name}</p>
                <p>Email: {facultyProfile.user.email}</p>
                <p>Phone: {facultyProfile.user.phone}</p>
                <p>Department: {facultyProfile.department.name}</p>
                <p>Office Hours: {facultyProfile.office_hours}</p>
            </div>
            {/* Other faculty-specific features like class list, etc. */}
        </div>
    );
};

export default FacultyDashboard;
