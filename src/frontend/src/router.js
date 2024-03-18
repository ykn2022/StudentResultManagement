import MyCourse from './components/Course.vue';
import CourseList from './components/CourseList.vue';
import MyStudent from './components/Student.vue';
import StudentList from './components/StudentList.vue';
import MyResult from './components/Result.vue';
import ResultList from './components/ResultList.vue';
import MyHome from "./components/Home.vue";
import * as VueRouter from "vue-router";

const routes = [
    { path: '/', component: MyHome },
    { path: '/course', component: MyCourse },
    { path: '/course/list', component: CourseList },
    { path: '/student', component: MyStudent },
    { path: '/student/list', component: StudentList },
    { path: '/result', component: MyResult },
    { path: '/result/list', component: ResultList },
];

const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(),
    routes,
});
export default router;