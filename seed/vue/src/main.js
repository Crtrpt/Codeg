import { createApp } from 'vue'
import App from './App.vue'

import Antd from 'ant-design-vue';

import 'ant-design-vue/dist/antd.css';

import './index.css'

import { createRouter, createWebHashHistory } from "vue-router";

import route from "./route/index.js";

import store from "./store/index.js";

import { Button, message,Row,Col } from 'ant-design-vue';

const router = createRouter({
    history: createWebHashHistory(),
    routes: route,
});

const app = createApp(App);
app.config.productionTip = true;
app.use(Antd);
app.use(Button,message, Row, Col)
app.use(router);
app.use(store);
app.mount('#app')
