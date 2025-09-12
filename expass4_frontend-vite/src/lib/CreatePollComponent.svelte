

<script>

    let question = "";
    let optionText = "";
    let polls = [];
    let selectedUserId = null;
    let users = [];

    ///https://svelte.dev/docs/svelte/await-expressions
    ///Functions to communicate with controllers, so I can just call them
    async function loadUsers() {
        const res = await fetch("http://localhost:8080/users");
        users = await res.json();
    }

    async function loadPolls() {
        const res = await fetch("http://localhost:8080/polls");
        polls = await res.json();
    }

    async function createPoll() {
        if (!selectedUserId) return alert("Select a user first");
        const res = await fetch(`http://localhost:8080/polls?userId=${selectedUserId}&question=${encodeURIComponent(question)}`, { method: "POST" });
        const newPoll = await res.json();
        polls.push(newPoll);
        question = "";
        location.reload();
    }

    async function addOption(pollId) {
        const res = await fetch(`http://localhost:8080/polls/options?pollId=${pollId}&text=${encodeURIComponent(optionText)}`, { method: "POST" });
        const option = await res.json();

        const poll = polls.find(p => p.id === pollId);
        poll.options.push(option);
        optionText = "";
        location.reload();
    }

    loadUsers();
    loadPolls();
    ///Loading to get already existing users and polls here
</script>


<h2>Create Poll</h2>
<select bind:value={selectedUserId}>
    <option value="" disabled>Select user</option>
    {#each users as user}
        <option value={user.id}>{user.name}</option>
    {/each}
</select>

<input bind:value={question} placeholder="Ask a question!" />
<button on:click={createPoll}>Create Poll</button>


<h3>Existing Polls:</h3>
{#each polls as poll}
    <div>
        <strong>{poll.question}</strong>
        <ul>
            {#each poll.options as option}
                <li>{option.text}</li>
            {/each}
        </ul>

        <input bind:value={optionText} placeholder="Add option" />
        <button on:click={() => addOption(poll.id)}>Add Option</button>
    </div>
{/each}
