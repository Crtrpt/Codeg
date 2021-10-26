<template>
  <div>${filename} list


    <router-link :to="{name:'${filename}Detail',params: { id: '1' }}" >detail</router-link> |
    <router-link :to="{name:'${filename}Form'}" >form</router-link>
  </div>
</template>

<script>
export default {
  name: "${filename}List",
};
</script>
