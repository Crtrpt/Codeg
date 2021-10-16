<template>
  <div>
    <Header />
    <router-view class="page-content"></router-view>
    <Footer />
  </div>
</template>
<script lang="javascript">
import Header from "./page/Header.vue";
import Footer from "./page/Footer.vue";
export default {
  name: "Master",
  components: {
    Header,
    Footer,
  }
};
</script>
<style>
.page-content {
  min-height: 90vh;
}
</style>
