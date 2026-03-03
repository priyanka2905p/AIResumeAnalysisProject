window.onload=function(){
const form = document.getElementById('resumeForm');
const resultDiv = document.getElementById('result');
const fileSpan = document.getElementById('file');
const scoreSpan = document.getElementById('score');
const skillsSpan = document.getElementById('skills');
const recommendationSpan = document.getElementById('recommendation');

form.addEventListener('submit', function(e) {
    e.preventDefault();
    const file = document.getElementById('fileInput').files[0];
    const formData = new FormData();
    formData.append('file', file);

    fetch('http://localhost:8081/api/upload', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        resultDiv.style.display = 'block';
        fileSpan.textContent = data.file;
        scoreSpan.textContent = data.score;
        if(data.skills && Array.isArray(data.skills)){
        skillsSpan.innerHTML = data.skills.join(', ');
        }
        else{
         skillsSpan.textContent="No skills detected";
        }
        recommendationSpan.textContent = data.recommendation || "No recommendation";
    })
    .catch(err => {
        resultDiv.style.display = 'block';
        resultDiv.innerHTML = `<p style="color:red;">Error: ${err}</p>`;
    });
});
};