<template>
  <div class="home" :style="image"></div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      image: {
        backgroundImage:
          "url(https://i.pinimg.com/originals/f0/b6/15/f0b615f78dd809d68ec389f4bc8d94bb.jpg)"
      }
    };
  }
};
</script>

<style>
.home {
  height: 750px;
  background-repeat: no-repeat;
  background-size: cover !important;
}
</style>
