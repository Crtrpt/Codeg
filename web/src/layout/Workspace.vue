<script setup></script>

<template>
  <div class="flex flex-col c">
    <TopHeader />
    <div class="flex-grow flex-shrink flex flex-row project">
      <router-view />
    </div>
  </div>
</template>
<script>
import TopHeader from "./TopHeader.vue";
import LeftBar from "./LeftBar.vue";
import LeftList from "./ProjectList.vue";
import {
  PlusIcon,
  CogIcon,
  AdjustmentsIcon,
  BookOpenIcon,
  ChatAlt2Icon,
  ChartPieIcon,
  ChipIcon,
  CubeTransparentIcon,
  CodeIcon,
  CalendarIcon,
  ClipboardIcon,
} from "@heroicons/vue/solid";

export default {
  components: {
    TopHeader,
    LeftBar,
    LeftList,
  },
  data() {
    return {
      view: "kanban",
    };
  },
  methods: {
    goView(v) {
      this.view = v;
    },
  },
};
</script>
<style></style>
