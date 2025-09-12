<script>
    let polls = [];
    let users = [];
    let selectedUser = null;
    let selectedOption = null;

    ///Functions to communicate with controllers
    async function loadPolls() {
        const res = await fetch("http://localhost:8080/polls");
        polls = await res.json();
    }

    async function loadUsers() {
        const res = await fetch("http://localhost:8080/users");
        users = await res.json();
    }

    async function castVote() {
        if (!selectedUser || !selectedOption) return alert("Select user and option");
        await fetch("http://localhost:8080/votes?userId=${selectedUser}&optionId=${selectedOption}", {
            method: "POST"
        });

        alert("Vote is now casted!");
        location.reload();
    }

    loadPolls();
    loadUsers();
</script>


<h2>Vote on Poll</h2>
<select bind:value={selectedUser}>
    <option value="" disabled>Select user</option>
    {#each users as user}
        <option value={user.id}>{user.name}</option>
    {/each}
</select>


{#each polls as poll}
    <div>
        <strong>{poll.question}</strong>
        <ul>
            {#each poll.options as option}
                <li>
                    <input type="radio" bind:group={selectedOption} value={option.id} /> {option.text}
                </li>
            {/each}
        </ul>
    </div>
{/each}


<button on:click={castVote}>Vote</button>



