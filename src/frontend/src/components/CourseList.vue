<template>
  <div class="form-container">
    <h1>Course List</h1>
    <table class="table-container centerTable">
      <thead>
      <tr>
        <th>Course Name</th>
        <th>Delete</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="course in courseOptions" :key="course.id">
        <td class="centerAlign">{{course.courseName}}</td>
        <td class="centerAlign delete" @click="deleteCourse(course.id)"> X </td>
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
  name: 'CourseList',
  components: {
    Toast
  },
  data() {
    return {
      courseOptions : [],
      successMessage: '',
      errorMessage: ''
    };
  },
  mounted(){
    axios.get('/api/courses')
        .then(response => {
          this.courseOptions = response.data;
        })
        .catch(error => {
          console.log(error);
          this.showErrorToast('Error loading all courses', error);
        });
  },
  methods: {
    async deleteCourse(courseId) {
      try {
        const response = await fetch('/api/courses/'+ courseId, {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json'
          }
        });

        if (response.ok) {
          this.showSuccessToast('Course deleted successfully!');
          this.courseOptions = this.courseOptions.filter(c => c.id !== courseId);
        } else {
          this.showErrorToast('Failed to delete course');
        }
      } catch (error) {
        console.error('Error deleting the course', error);
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