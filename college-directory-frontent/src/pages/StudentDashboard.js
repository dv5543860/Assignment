import React, { useEffect, useState } from 'react';
import UserService from '../services/UserService';

const StudentDashboard = () => {
    const [studentProfile, setStudentProfile] = useState(null);

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const response = await UserService.getStudentProfile();
                setStudentProfile(response.data);
            } catch (error) {
                console.error('Error fetching student profile', error);
            }
        };

        fetchProfile();
    }, []);

    if (!studentProfile) return <div>Loading...</div>;

    return (
        <div>
            <h2>Student Dashboard</h2>
            <div>
                <img src={studentProfile.photo} alt="Profile" />
                <p>Name: {studentProfile.user.name}</p>
                <p>Email: {studentProfile.user.email}</p>
                <p>Phone: {studentProfile.user.phone}</p>
                <p>Department: {studentProfile.department.name}</p>
                <p>Year: {studentProfile.year}</p>
            </div>
            {/* Other student-specific features like course list, grades, etc. */}
        </div>
    );
};

export default StudentDashboard;
