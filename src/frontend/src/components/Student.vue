<template>
  <div class="form-container">
    <h1>Add New Student</h1>
    <form @submit.prevent="submitForm">
      <div class="form-row">
        <div class="form-column">
          <label for="firstName">First Name:</label>
          <input type="text" id="firstName" v-model="formData.firstName" required>
        </div>
      </div>
      <div class="form-row">
        <div class="form-column">
          <label for="familyName">Family Name:</label>
          <input type="text" id="familyName" v-model="formData.familyName" required>
        </div>
      </div>
      <div class="form-row">
        <div class="form-column">
          <label for="birthDate">Date of Birth:</label>
          <input type="date" id="birthDate" v-model="formData.birthDate" required>
        </div>
      </div>
      <div class="form-row">
        <div class="form-column">
          <label for="emailAddress">Email Address:</label>
          <input type="email" id="emailAddress" v-model="formData.emailAddress" required>
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
  name: 'MyStudent',
  components: {
    Toast
  },
  data() {
    return {
      formData: {
        firstName: '',
        familyName: '',
        birthDate: '',
        emailAddress: ''
      },
      successMessage: '',
      errorMessage: ''
    };
  },
  methods: {
    async submitForm() {
      try {
        const providedDate = new Date(this.formData.birthDate);

        const currentDate = new Date();
        const tenYearsAgo = new Date(currentDate);
        tenYearsAgo.setFullYear(currentDate.getFullYear() - 10);
        if (providedDate > tenYearsAgo) {
          this.showErrorToast('Student must be at least 10 years old.')
          return;
        }

        // simplistic email validation
        let emailRegex = new RegExp("^[\\._a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$");

        const formEmail = this.formData.emailAddress;
        if (emailRegex.exec(formEmail) === null){
          this.showErrorToast('Not a valid email format.')
          return;
        }

        const response = await fetch('/api/students', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.formData)
        });

        if (response.ok) {
          this.formData.firstName = '';
          this.formData.familyName = '';
          this.formData.birthDate = '';
          this.formData.emailAddress = '';
          this.showSuccessToast('Student created successfully!');
        } else if (response.status == '409') {
          this.showErrorToast('A student with the entered data already exists!');
        } else {
          this.showErrorToast('Failed to create student!');
          throw new Error('Failed to create student');
        }
      } catch (error) {
        console.error('Error submitting form:', error);
        this.formData.firstName = '';
        this.formData.familyName = '';
        this.formData.birthDate = '';
        this.formData.emailAddress = '';
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
