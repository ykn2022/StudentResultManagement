<template>
  <div class="form-container">
    <h1>Add New Result</h1>
    <form @submit.prevent="submitForm">
      <div class="form-row">
        <div class="form-column">
          <label for="courseId">Course Name:</label>
          <select id="courseId" v-model="formData.courseId" required>
            <option v-for="(courseOption,index) in courseOptions" :key="index" :value="courseOption.id">{{courseOption.courseName}}</option>
          </select>
        </div>
      </div>
      <div class="form-row">
        <div class="form-column">
          <label for="studentId">Student Name:</label>
          <select id="studentId" v-model="formData.studentId" required>
            <option v-for="(studentOption,index) in studentOptions" :key="index" :value="studentOption.id">{{studentOption.firstName + ' ' + studentOption.familyName}}</option>
          </select>
        </div>
      </div>
      <div class="form-row">
        <div class="form-column">
          <label for="score">Score:</label>
          <select id="score" v-model="formData.selectedScore" required>
            <option v-for="(scoreOption,index) in scoreOptions" :key="index" :value="scoreOption.value">{{scoreOption.label}}</option>
          </select>
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
import axios from 'axios';
import Toast from "@/components/Toast";

export default {
  name: 'MyResult',
  components: {
    Toast
  },
  data() {
    return {
      courseOptions: [],
      studentOptions: [],
      scoreOptions: [
        {value: 'A', label: 'A'},
        {value: 'B', label: 'B'},
        {value: 'C', label: 'C'},
        {value: 'D', label: 'D'},
        {value: 'E', label: 'E'},
        {value: 'F', label: 'F'}
      ],
      formData: {
        courseId: '',
        studentId: '',
        selectedScore: ''
      },
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
          this.showErrorToast('Error occurred while loading all courses.');
        });
    axios.get('/api/students')
        .then(response => {
          this.studentOptions = response.data;
        })
        .catch(error => {
          console.log(error);
          this.showErrorToast('Error occurred while loading all students.');
        });
  },
  methods: {
    async submitForm() {
      try {
        const result = {
            "course": {
              "courseId": this.formData.courseId
            },
            "student" : {
              "studentId" : this.formData.studentId
            },
            "score": this.formData.selectedScore
        };

        const response = await fetch('/api/results', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(result)
        });

        if (response.ok) {
          this.formData.courseId= '';
          this.formData.studentId = '';
          this.formData.selectedScore = '';
          this.showSuccessToast('Result created successfully!');
        } else if (response.status == '409') {
          this.showErrorToast('A result with the entered data already exists!');
        } else {
          this.showErrorToast('Failed to create result');
        }
      } catch (error) {
        console.error('Error submitting form:', error);
        this.formData.courseId= '';
        this.formData.studentId = '';
        this.formData.selectedScore = '';
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
        this.successMessage = '';
      }, 2000);
    }
  },
};
</script>