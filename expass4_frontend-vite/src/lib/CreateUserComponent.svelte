<script>
    let name = "";
    let users = [];

    ///Functions to communicate with controllers
    async function createUser() {
        const res = await fetch("http://localhost:8080/users", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name })

        });

        const newUser = await res.json();
        users.push(newUser);

        name = "";

        location.reload();
    }


    async function loadUsers() {
        const res = await fetch("http://localhost:8080/users");
        users = await res.json();
    }

    loadUsers();
</script>

<h2>Create User</h2>
<input bind:value={name} placeholder="Enter your name" />
<button on:click={createUser}>Create</button>


<h3>Existing Users:</h3>
<ul>
    {#each users as user}
        <li>{user.id}: {user.name}</li>
    {/each}
</ul>
