<template>
  <a-layout class="master-layout">
    <a-layout-header class="header">
      <menu-unfold-outlined
        v-if="collapsed"
        class="trigger"
        @click="() => (collapsed = !collapsed)"
      />
      <menu-fold-outlined
        v-else
        class="trigger"
        @click="() => (collapsed = !collapsed)"
      />
      <a class="system_name">Codeg</a>
      <a-menu
        v-model:selectedKeys="selectedKeys1"
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1">首页</a-menu-item>
        <a-menu-item key="2">用户</a-menu-item>
        <a-menu-item key="3">系统设置</a-menu-item>
      </a-menu>
    </a-layout-header>
    <a-layout>
      <a-layout-sider
        width="250"
        style="background: #fff"
        v-model:collapsed="collapsed"
        :trigger="null"
        collapsible
      >
        <a-menu
          v-model:selectedKeys="selectedKeys2"
          v-model:openKeys="openKeys"
          mode="inline"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                <span>用户管理</span>
              </span>
            </template>
            <a-menu-item key="1">用户列表</a-menu-item>
            <a-menu-item key="1-1">会员列表</a-menu-item>
            <a-menu-item key="2">用户分析</a-menu-item>
            <a-menu-item key="3">用户设置</a-menu-item>
            <a-menu-item key="5-1">用户操作日志</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
              <span>
                <laptop-outlined />
                <span>系统设置</span>
              </span>
            </template>
            <a-menu-item key="5">会员管理</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <template #title>
              <span>
                <notification-outlined />
                <span>权限管理</span>
              </span>
            </template>
            <a-menu-item key="9">角色管理</a-menu-item>
            <a-menu-item key="10">权限管理</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub4">
            <template #title>
              <span>
                <notification-outlined />
                <span>组织管理</span>
              </span>
            </template>
            <a-menu-item key="9-1">组织管理</a-menu-item>
            <a-menu-item key="9-2">部门管理</a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 10px">
        <a-tabs
          v-model:activeKey="activeKey"
          type="editable-card"
          @edit="onEdit"
        >
          <a-tab-pane
            v-for="pane in panes"
            :key="pane.key"
            :tab="pane.title"
            :closable="pane.closable"
          >
            <router-view class="content"></router-view>
          </a-tab-pane>
        </a-tabs>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script lang="ts">
import {
  UserOutlined,
  LaptopOutlined,
  NotificationOutlined,
} from "@ant-design/icons-vue";
import {
  VideoCameraOutlined,
  UploadOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined,
} from "@ant-design/icons-vue";
import { defineComponent, ref } from "vue";
export default defineComponent({
  components: {
    UserOutlined,
    LaptopOutlined,
    NotificationOutlined,
    VideoCameraOutlined,
    UploadOutlined,
    MenuUnfoldOutlined,
    MenuFoldOutlined,
  },
  setup() {
    const panes = ref([
      { title: "Tab 1", content: "Content of Tab 1", key: "1" },
      { title: "Tab 2", content: "Content of Tab 2", key: "2" },
      {
        title: "Tab 3",
        content: "Content of Tab 3",
        key: "3",
        closable: false,
      },
    ]);

    const activeKey = ref(panes.value[0].key);

    const newTabIndex = ref(0);

    const callback = (key: string) => {
      console.log(key);
    };

    const add = () => {
      activeKey.value = `newTab${++newTabIndex.value}`;
      panes.value.push({
        title: "New Tab",
        content: "Content of new Tab",
        key: activeKey.value,
      });
    };

    const remove = (targetKey: string) => {
      let lastIndex = 0;
      panes.value.forEach((pane, i) => {
        if (pane.key === targetKey) {
          lastIndex = i - 1;
        }
      });
      panes.value = panes.value.filter((pane) => pane.key !== targetKey);
      if (panes.value.length && activeKey.value === targetKey) {
        if (lastIndex >= 0) {
          activeKey.value = panes.value[lastIndex].key;
        } else {
          activeKey.value = panes.value[0].key;
        }
      }
    };

    const onEdit = (targetKey: string | MouseEvent, action: string) => {
      if (action === "add") {
        add();
      } else {
        remove(targetKey as string);
      }
    };
    return {
      panes,
      activeKey,
      callback,
      onEdit,
      selectedKeys1: ref<string[]>(["2"]),
      selectedKeys2: ref<string[]>(["1"]),
      openKeys: ref<string[]>(["sub1"]),
      collapsed: ref<boolean>(false),
    };
  },
});
</script>
<style>
.content {
  background-color: white;
  padding: 10px;
}
.trigger {
  color: white;
  margin: 0px 40px;
}
.ant-layout-header {
  display: flex;
  justify-content: start;
  align-items: center;
  padding: 0px;
}
.system_name {
  font-size: 20px;
  color: white;
  line-height: 64px;
  height: 64px;
}
</style>
