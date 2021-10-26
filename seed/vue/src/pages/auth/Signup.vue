<template>
  <a-row>
    <a-col :xs="9"> </a-col>
    <a-col :xs="6">
      <a-card title="注册" style="margin-top: 30%">
        <template #extra><a @click="goLogin">已有账号?去登录</a></template>
        <a-form :model="form" class="login_form">
          <a-form-item>
            <a-input
              v-model:value="form.name"
              placeholder="输入注册账号"
              size="large"
            />
          </a-form-item>

          <a-form-item>
            <a-input
              v-model:value="form.desc"
              type="password"
              placeholder="输入注册密码"
              size="large"
            />
          </a-form-item>
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
              placeholder="输入验证码"
              size="large"
            />
          </a-form-item>
          <a-form-item>
            <a-checkbox value="1" name="license">我同意许可协议</a-checkbox>
          </a-form-item>
          <a-form-item>
            <a-button type="primary" @click="submit">登录</a-button>
            <a-button style="margin-left: 10px" @click="goSignup"
              >注册</a-button
            >
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
        phone: "",
        verifCode: "",
      },
    };
  },
  methods: {
    goLogin(e) {
      this.$router.push({ name: "login" });
    },
    submit(e) {
      e.stopPropagation();
      e.defaultPrevented();
      console.log(this.form);
    },
  },
};
</script>
