const API_BASE='http://localhost:9090/api/code';
const USER_ID_KEY = 'ai_codereviewer_user_id';

function getUserId(){
    const id = localStorage.getItem(USER_ID_KEY);
    if(!id){
        id= crypto.randomUUID();
        localStorage.setItem(USER_ID_KEY,id);
    }

    return id;
}

const USER_ID = getUserId();

async function submitCode(params) {
    const fileInput = document.getElementById('fileInput');
    const textArea = document.getElementById('codeArea');
    const analyzeBtn = document.getElementById('analyzeBtn');

    let code = textArea.value;
    let fileName = 'pasted_code.txt';

    if(fileInput && fileInput.files.length>0){
        const file = fileInput.files[0];
        code = await file.text();
        fileName = file.name;
    }

    if(!code.trim()){
        alert("Please enter code or upload a file!");
        return;
    }

    analyzeBtn.disabled = true;
    analyzeBtn.innerText='Uploading...';

    //call backend API
    try{
        const reponse = await fetch(`${API_BASE}/upload`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json'},
            body: JSON.stringify({
                userId: USER_ID,
                filename: filename,
                language: detectLanguage(filename),
                code: code
            })
        });

        if(Response.ok){
            //do something
        } else{
            alert('Upload failed!');
        }
    } catch(e){
        console.error(e);
        console.log("Error connection to server");
    } finally{
        analyzeBtn.disabled= false;
        analyzeBtn.innerText='Analyze Code';
    }
}

function detectLanguage(filename){
    if(filename.endsWith('.js')) return 'javascript';
    if(filename.endsWith('.java')) return 'java';
    if(filename.endsWith('.py')) return 'python';
    if(filename.endsWith('.cpp')) return 'cpp';

    return 'text';
}