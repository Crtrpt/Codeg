<template>
  <div>User list

    <a-button type="primary">Primary Button</a-button>
    <router-link :to="{name:'UserDetail',params: { id: '1' }}" >detail</router-link> |
    <router-link :to="{name:'UserForm'}" >form</router-link>
  </div>
</template>

<script>
import { Button } from 'ant-design-vue';
export default {
 
  name: "UserList",
};
</script>
