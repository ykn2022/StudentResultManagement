<template>
  <div class="navigation">
    <nav>
      <ul>
        <li class="systemLink"><router-link to ="/">Home</router-link></li>
        <li class="systemLink"><router-link to ="/student">Add New Students</router-link></li>
        <li class="systemLink"><router-link to ="/student/list">Students List</router-link></li>
        <li class="systemLink"><router-link to ="/course">Add New Courses</router-link></li>
        <li class="systemLink"><router-link to ="/course/list">Courses List</router-link></li>
        <li class="systemLink"><router-link to ="/result">Add New Results</router-link></li>
        <li class="systemLink"><router-link to ="/result/list">Results List</router-link></li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'NavigationBar'
}
</script>

<style scoped>
  .navigation {
    width: 20%;
    height: 100%;
    float: left;
  }
  .systemLink {
    text-align: left;
    padding-bottom: 15px;
  }
</style>