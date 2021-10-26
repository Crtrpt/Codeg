<template>
  <a-row>
    <a-col :xs="9"> </a-col>
    <a-col :xs="6">
      <a-card title="登录" style="margin-top: 30%">
        <template #extra><a @click="goSignup">没有账号?去注册</a></template>
        <a-form :model="form" class="login_form">
          <a-form-item>
            <a-input
              v-model:value="form.name"
              placeholder="输入登录的用户"
              size="large"
            />
          </a-form-item>

          <a-form-item>
            <a-input
              v-model:value="form.desc"
              type="password"
              placeholder="输入登录的密码"
              size="large"
            />
          </a-form-item>
          <a-form-item>
            <a-checkbox value="1" name="remember">记住登录密码</a-checkbox>
            <a-checkbox value="1" name="license">我同意许可协议</a-checkbox>
          </a-form-item>

          <a-form-item>
            <a-button type="primary" @click="submit">登录</a-button>
            <a-button style="margin-left: 10px" @click="goSignup"
              >注册</a-button
            >
          </a-form-item>
          <a-form-item>
            <a @click="goFound">密码丢失? 找回密码</a>
          </a-form-item>
        </a-form></a-card
      >
    </a-col>
    <a-col :xs="9"> </a-col>
  </a-row>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      form: {
        account: "",
        password: "",
      },
    };
  },
  methods: {
    goFound(e) {
      this.$router.push({ name: "found" });
    },
    goSignup(e) {
      this.$router.push({ name: "signup" });
    },
    submit(e) {
      e.defaultPrevented();
      e.stopPropagation();

      console.log(this.form);
    },
  },
};
</script>

<style scoped>
.login_form {
}
</style>
