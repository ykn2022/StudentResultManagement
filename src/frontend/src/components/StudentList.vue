<template>
  <div class="form-container">
    <h1>Student List</h1>
    <table class="table-container">
      <thead>
      <tr>
        <th>Name & Family Name</th>
        <th>DOB</th>
        <th>Email</th>
        <th>Delete</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="student in studentOptions" :key="student.id">
        <td>{{student.firstName + ' ' + student.familyName}}</td>
        <td class="centerAlign">{{new Date(student.birthDate).toLocaleDateString()}}</td>
        <td class="rightAlign">{{student.emailAddress}}</td>
        <td class="centerAlign delete" @click="deleteStudent(student.id)"> X </td>
      </tr>
      </tbody>
    </table>

    <Toast v-if="successMessage" type="success" :message="successMessage" />
    <Toast v-if="errorMessage" type="error" :message="errorMessage" />
  </div>
</template>

<script>
import '../assets/formStyles.css';
import axios from "axios";
import Toast from "@/components/Toast";

export default {
  name: 'StudentList',
  components: {
    Toast
  },
  data() {
    return {
      studentOptions : [],
      successMessage: '',
      errorMessage: ''
    };
  },
  mounted(){
    axios.get('/api/students')
        .then(response => {
          this.studentOptions = response.data;
        })
        .catch(error => {
          console.log(error);
          this.showErrorToast('Error occurred while loading all students.')
        });
  },
  methods: {
    async deleteStudent(studentId) {
      try {
        const response = await fetch('/api/students/'+ studentId, {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json'
          }
        });

        if (response.ok) {
          this.showSuccessToast('Student deleted successfully!');
          this.studentOptions = this.studentOptions.filter(s => s.id !== studentId);
        } else {
          this.showErrorToast('Failed to delete student');
        }
      } catch (error) {
        console.error('Error deleting the student', error);
      }
    },
    showSuccessToast(msg) {
      this.successMessage = msg;
      setTimeout(() => {
        this.successMessage = '';
      }, 2000);
    },
    showErrorToast(msg) {
      this.errorMessage = msg;
      setTimeout(() => {
        this.errorMessage = '';
      }, 2000);
    }
  }
};
</script>