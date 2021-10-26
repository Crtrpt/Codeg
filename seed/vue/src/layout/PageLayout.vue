<template>
  <div class="page_layout">
    <header></header>
    <router-view> </router-view>
    <PageFooter></PageFooter>
  </div>
</template>
<script lang="ts">
import PageFooter from "./PageFooter.vue";
export default {
  name: "Master",
  components: {
    PageFooter,
  },
  setup() {
    console.log("App 初始化");
  },
};
</script>
<style>
.page_layout {
  background-image: url("bg.jfif");
  background-position: center;
  background-size: cover;
  bottom: 0;
  right: 0;
  left: 0;
  top: 0;
  position: absolute;
}
</style>
