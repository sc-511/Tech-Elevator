<template>
  <div id="register" class="text-center">
   <div class="nav1"></div>
    <div class="nav2"></div>
    <div class="nav3"></div>

  <div class="container">
    <div class="row justify-content-center align-items-center h-40">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <form class="form-signin">
              <div class="form-label-group">
                <div id="register" class="text-center">
                  <form class="form-register" @submit.prevent="register">
                    <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
                    <div class="alert alert-danger" role="alert" v-if="registrationErrors">
                      {{ registrationErrorMsg }}
                    </div>
                    <label for="username" class="sr-only">Username</label>
                    <input
                      type="text"
                      id="username"
                      class="form-control"
                      placeholder="Username"
                      v-model="user.username"
                      required
                      autofocus
                    />
                    <label for="password" class="sr-only">Password</label>
                    <input
                      type="password"
                      id="password"
                      class="form-control"
                      placeholder="Password"
                      v-model="user.password"
                      required
                    />
                    <input
                      type="password"
                      id="confirmPassword"
                      class="form-control"
                      placeholder="Confirm Password"
                      v-model="user.confirmPassword"
                      required
                    />
                    <router-link :to="{ name: 'login' }">Have an account?</router-link>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">
                      Create Account
                    </button>
                  </form>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

.nav2{
  border: solid 3px white;
  width:430px;
  left: 12.5%;
  top: 55px;
  position: absolute;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.961);
}
.container{
  height: 1080px;
}
.row{
  margin-top: 10%;
  
}
:root {
  --input-padding-x: 1.5rem;
  --input-padding-y: .75rem;
}

.card-signin {
border: solid black 2px;
  border-radius: 20px;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.961);
}

.card-signin .card-title {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
}

.card-signin .card-body {
  padding: 2rem;
}
.card-body{
  border-radius: 1rem;
  background-image: url("https://thumbs.dreamstime.com/b/comic-pop-art-background-lightning-blast-halftone-dots-cartoon-vector-illustration-orange-comic-background-151418372.jpg%22") ;
  background-size: cover;

}

.form-signin {
  width: 100%;
}

.form-signin .btn {
  font-size: 80%;
  border-radius: 5rem;
  letter-spacing: .1rem;
  font-weight: bold;
  padding: 1rem;
  transition: all 0.2s;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group input {
  height: auto;
  border-radius: 2rem;
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  line-height: 1.5;
  color: #495057;
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}
.form-label-group select {
  color: #737678;
  height: auto;
  border-radius: 2rem;
}


</style>


