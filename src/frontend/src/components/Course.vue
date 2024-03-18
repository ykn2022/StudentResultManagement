<template>
  <div class="form-container">
    <h1>Add New Course</h1>
    <form @submit.prevent="submitForm">
      <div class="form-row">
        <div class="form-column">
          <label for="courseName">Course Name:</label>
          <input type="text" id="courseName" v-model="formData.courseName" required>
        </div>
      </div>
      <div class="form-row">
        <button type="submit">Submit</button>
      </div>

      <Toast v-if="successMessage" type="success" :message="successMessage" />
      <Toast v-if="errorMessage" type="error" :message="errorMessage" />
    </form>
  </div>
</template>

<script>
import '../assets/formStyles.css';
import Toast from "@/components/Toast";

export default {
  name: 'MyCourse',
  components: {
    Toast
  },
  data() {
    return {
      formData: {
        courseName: ''
      },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    async submitForm() {
      try {
        const response = await fetch('/api/courses', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.formData)
        });

        if (response.ok) {
          this.formData.courseName = '';

          this.showSuccessToast('Course created successfully!');
        } else if (response.status == '409') {
          this.showErrorToast('A course with the entered data already exists!');
        } else {
          this.showErrorToast('Failed to create course');
        }
      } catch (error) {
        console.error('Error submitting form:', error);
        this.formData.courseName = '';
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