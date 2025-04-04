import React, { useState } from 'react';
import './App.css';

function App() {
  const [name, setName] = useState('');
  const [vote, setVote] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch('http://localhost:8080/api/vote', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name, voteChoice: vote }),
    });
    const result = await response.json();
    setMessage(response.ok ? 'Vote recorded!' : result.error);
  };

  return (
    <div className="App">
      <h1>Utrains Voting App</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Your Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <div>
          <label>
            <input
              type="radio"
              value="Trump"
              checked={vote === 'Trump'}
              onChange={(e) => setVote(e.target.value)}
            />
            Trump
          </label>
          <label>
            <input
              type="radio"
              value="Biden"
              checked={vote === 'Biden'}
              onChange={(e) => setVote(e.target.value)}
            />
            Biden
          </label>
        </div>
        <button type="submit">Vote</button>
      </form>
      {message && <p className={message.includes('error') ? 'error' : 'success'}>{message}</p>}
    </div>
  );
}

export default App;