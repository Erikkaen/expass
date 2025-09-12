<script>
    import CreateUserComponent from "./lib/CreateUserComponent.svelte";
    import CreatePollComponent from "./lib/CreatePollComponent.svelte";
    import VoteComponent from "./lib/VoteComponent.svelte";
</script>

<h1>Poll App</h1>
<style>
    h1 {
        color: #f3c34d;
        font-family: 'Comic Sans MS', cursive;
        font-size: 5em;
    }
</style>



<CreateUserComponent />
<hr />
<CreatePollComponent />
<hr />
<VoteComponent />
