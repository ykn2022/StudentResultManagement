<template>
  <NavigationBar/>
  <router-view/>
</template>

<script>
import NavigationBar from "@/components/NavigationBar";
import MyCourse from './components/Course.vue';
import MyStudent from './components/Student.vue';
import MyResult from './components/Result.vue';
import MyHome from "./components/Home.vue";
import Toast from "./components/Toast.vue";

export default {
  name: 'App',
  components: {
    NavigationBar, MyHome, MyCourse, MyResult, MyStudent, Toast
  }
}
</script>

<style>
#app {
  font-family: Calibri, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
  margin-top: 5px;
}
</style>
