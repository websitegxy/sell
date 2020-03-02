<template>
  <div class="login">
    <div id="logo">
      <span id="project-name">房产直销系统</span>
      <img src="../assets/img/login_logo.jpg">
    </div>
    <div id="form-div">
      <el-form :model="loginForm" status-icon :rules="rules" :label-position="labelPostion" label-width="40px" ref="ruleForm" class="ruleForm" >
            <el-form-item class="item-form" label="账号" prop="name">
                <el-input type="text" class="my-input" v-model="loginForm.name" autocomplete="off" placeholder="请输入账号"></el-input>
            </el-form-item>
             <el-form-item label="密码" class="item-form" prop="pass">
              <el-input  type="password" class="my-input" v-model="loginForm.pass" autocomplete="off" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item class="item-form">
            <el-checkbox label="记住密码"  name="type"></el-checkbox>
            </el-form-item>
            <el-form-item class="item-form">
              <el-button type="primary" @click="login">登录</el-button>
            </el-form-item>
            <el-form-item class="item-form">
              <el-link :underline="false" type="danger">还没有账号？创建一个账号</el-link>
            </el-form-item>
      </el-form>
      </div>
    <div class="footer">
      <span>Copyright © 售房网 2020 All Rights Reserved </span>
    </div>
  </div>
</template>

<script>
import CONSTANT from '@/assets/js/const.js'
import router from '@/router'
export default {

  name: 'Login',
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.loginForm.pass !== '') {
          this.$refs.ruleForm.validateField('pass')
        }
        callback()
      }
    }
    var validateName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入账号'))
      } else {
        callback()
      }
    }
    return {
      labelPostion: 'top',
      loginForm: {
        name: '',
        pass: ''
      },
      rules: {
        pass: [{ validator: validatePass, trigger: 'blur' }],
        name: [{ validator: validateName, trigger: 'blur' }]
      }
    }
  },
  methods: {
    login: function () {
      this.$post('/login', {
        username: this.loginForm.name,
        password: this.loginForm.pass
      })
        .then(response => {
          if (CONSTANT.STATUS_CODE.SUCCESS === response.RespCode) {
            this.$message.success('登录成功')
            router.push('/')
          } else {
            this.$message.error(response.RespDesc)
          }
        })
      // alert(this.username + this.password)
    }
  }

}

</script>

<style scoped>
.login{
    width: 100vw;
    height: 100vh;
    background-image: url("../assets/img/login.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    font-size: 16px;
}
#logo{
  text-align: center;
  width: 100vw;
  /*height: 30vh;*/
  padding-top: 5vh;
  padding-bottom: 5vh;
}
#logo > span{
  position: absolute;
  left: 20px;
}
#logo > img{
  border-radius: 50%;
  width: 6vw;
}
#form-div{
  width: 350px;
  border-radius: 1rem;
  background-color: rgba(0,0,0,0.15);
  padding: 20px 20px 10px 20px;
  margin: 0 auto;
}
#form-div button{
  width: 100%;
}
#form-div .item-form{
  margin-bottom: 4px!important;
}

#project-name{
  font-family: Arial;
  font-size: 30px;
  font-weight: bolder;
  color: rgb(226, 141, 43);
}
.footer{
  width: 350px;
  font-family: Arial;
  color: rgb(85, 82, 82);
  font-size: 16px;
  margin-top: 100px;
  margin: 100px auto 100px;
  /* transform: translateX(-50%) translateY(-50%); */
}

</style>
