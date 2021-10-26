<template>
  <a-row>
    <a-col :xs="9"> </a-col>
    <a-col :xs="6">
      <a-card title="找回密码" style="margin-top: 30%">
        <template #extra><a @click="goLogin">返回?去登录</a></template>
        <a-form :model="form" class="login_form">
          <a-form-item>
            <a-input-group compact>
              <a-input
                v-model:value="form.desc"
                type="password"
                placeholder="输入注册手机号"
                size="large"
              >
                <template #addonAfter>
                  <a-button type="primary" @click="submit">发送验证码</a-button>
                </template></a-input
              >
            </a-input-group>
          </a-form-item>

          <a-form-item>
            <a-input
              v-model:value="form.desc"
              type="password"
              placeholder="验证码"
              size="large"
            />
          </a-form-item>
          <a-form-item>
            <a-input
              v-model:value="form.desc"
              type="password"
              placeholder="新密码"
              size="large"
            />
          </a-form-item>
          <a-form-item>
            <a-input
              v-model:value="form.desc"
              type="password"
              placeholder="确认新密码"
              size="large"
            />
          </a-form-item>
          <a-form-item>
            <a-checkbox value="1" name="license">我同意许可协议</a-checkbox>
          </a-form-item>

          <a-form-item>
            <a-button type="primary" @click="submit">确认</a-button>
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
    goLogin(e) {
      this.$router.push({ name: "login" });
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
