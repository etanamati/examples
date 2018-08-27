import React, { Component } from 'react'
import axios from 'axios';

class FileUpload extends Component {
  constructor() {
    super();
    this.state = {
      file: null
    };
  }

  submitFile = (event) => {
    event.preventDefault();
    axios.get(`http://localhost:8080/upload-files/url-envio?name=${this.state.file[0].name}`)
    .then(response => {
      this.uploadFileS3(response.data);
    })
  }
  
  uploadFileS3(urlUpload){
    const formData = new FormData();
    formData.append('file', this.state.file[0]);
    axios.put(urlUpload, formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    }).then(response => {
      // handle your response;
      console.log('response => ', response)
    }).catch(error => {
      // handle your error
      console.log('error => ', error)
    });
  }

  handleFileUpload = (event) => {
    this.setState({ file: event.target.files });
  }

  render() {
    return (
      <form onSubmit={this.submitFile}>
        <input label='upload file' type='file' onChange={this.handleFileUpload} />
        <button type='submit'>Send</button>
      </form>
    );
  }
}

export default FileUpload;