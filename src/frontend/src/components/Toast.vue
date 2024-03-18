<template>
  <div v-if="visible" :class="[type === 'success' ? 'toast success' : 'toast error']">
    {{ message }}
  </div>
</template>

<script>
export default {
  props: {
    type: String,
    message: String
  },
  data() {
    return {
      visible: true
    };
  },
  mounted() {
    setTimeout(() => {
      this.visible = false;
    }, 2000);
  }
}
</script>

<style scoped>
  .toast {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 10px 20px;
    border-radius: 5px;
    color: #fff;
    font-weight: bold;
  }

  .success {
    background-color: #4caf50;
  }

  .error {
    background-color: #f44336;
  }
</style>