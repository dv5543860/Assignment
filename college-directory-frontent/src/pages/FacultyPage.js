// src/pages/FacultyPage.js
import React, { useState, useEffect } from 'react';
import { getAllFaculties, createFaculty } from '../services/facultyService';

const FacultyPage = () => {
  const [faculties, setFaculties] = useState([]);
  const [newFaculty, setNewFaculty] = useState({ name: '', email: '' });

  useEffect(() => {
    const fetchFaculties = async () => {
      try {
        const data = await getAllFaculties();
        setFaculties(data);
      } catch (error) {
        console.error('Error fetching faculties:', error);
      }
    };
    fetchFaculties();
  }, []);

  const handleCreate = async () => {
    try {
      const createdFaculty = await createFaculty(newFaculty);
      setFaculties([...faculties, createdFaculty]);
    } catch (error) {
      console.error('Error creating faculty:', error);
    }
  };

  return (
    <div>
      <h1>Faculty List</h1>
      <ul>
        {faculties.map((faculty) => (
          <li key={faculty.id}>{faculty.name}</li>
        ))}
      </ul>
      <div>
        <h2>Add New Faculty</h2>
        <input
          type="text"
          placeholder="Name"
          value={newFaculty.name}
          onChange={(e) => setNewFaculty({ ...newFaculty, name: e.target.value })}
        />
        <input
          type="email"
          placeholder="Email"
          value={newFaculty.email}
          onChange={(e) => setNewFaculty({ ...newFaculty, email: e.target.value })}
        />
        <button onClick={handleCreate}>Add Faculty</button>
      </div>
    </div>
  );
};

export default FacultyPage;
