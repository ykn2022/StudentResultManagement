<template>
  <div class="form-container">
    <h1>Result List</h1>
    <table class="table-container">
      <thead>
      <tr>
        <th>Course</th>
        <th>Student</th>
        <th>Score</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(result,index) in resultOptions" :key="index">
        <td>{{result.course.courseName}}</td>
        <td>{{result.student.firstName + ' ' + result.student.familyName}}</td>
        <td>{{result.score}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import '../assets/formStyles.css';
import axios from "axios";

export default {
  name: 'ResultList',
  data() {
    return {
      resultOptions : []
    };
  },
  mounted(){
    axios.get('/api/results')
        .then(response => {
          console.log(response.data);
          this.resultOptions = response.data;
        })
        .catch(error => {
          console.log(error);
          this.showErrorToast('Error occurred while loading all results.');
        });
  }
};
</script>