// src/services/facultyService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/faculties'; // URL of your backend API

export const getAllFaculties = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching faculties:', error);
    throw error;
  }
};

export const getFacultyById = async (id) => {
  try {
    const response = await axios.get(`${API_URL}/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error fetching faculty with ID ${id}:`, error);
    throw error;
  }
};

export const createFaculty = async (faculty) => {
  try {
    const response = await axios.post(API_URL, faculty);
    return response.data;
  } catch (error) {
    console.error('Error creating faculty:', error);
    throw error;
  }
};

export const updateFaculty = async (id, faculty) => {
  try {
    const response = await axios.put(`${API_URL}/${id}`, faculty);
    return response.data;
  } catch (error) {
    console.error(`Error updating faculty with ID ${id}:`, error);
    throw error;
  }
};

export const deleteFaculty = async (id) => {
  try {
    await axios.delete(`${API_URL}/${id}`);
  } catch (error) {
    console.error(`Error deleting faculty with ID ${id}:`, error);
    throw error;
  }
};
