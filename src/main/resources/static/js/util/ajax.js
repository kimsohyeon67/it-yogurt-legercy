const DEFAULT = {
  url: '',
  type: 'GET',
  cache: true,
  data: {},
}

window.ajax = {
  sendForm: (path, data) => {
    let sendFromResult;
    let url = window.location.origin;
    if (path.startsWith('http')) {
      url = path;
    } else if (path.startsWith('/')) {
      url += path;
    } else {
      url += '/' + path;
    }

    $.ajax({
      url,
      enctype: 'multipart/form-data',
      type: 'POST',
      cache: false,
      processData: false,
      contentType: false,
      data: data,
      success: result => {
       sendFromResult = result;
      },
      error: (request, status, error) => {
        return error;
      }
    });
    return sendFromResult;
  },

  request: async (path, options) => {
    var url = window.location.origin;
    if (path.startsWith('http')) {
      url = path;
    } else if (path.startsWith('/')) {
      url += path;
    } else {
      url += '/' + path;
    }

    return new Promise((resolve, reject) => {
      if (options.data && (options.type === 'POST' || options.type
          === 'DELETE')) {
        options.data = JSON.stringify(options.data);
      }
      $.ajax({
        ...DEFAULT,
        ...options,
        url,
        beforeSend: xhr => {
          xhr.setRequestHeader("Content-Type",
              "application/json;charset=UTF-8");
        },
        success: result => {
          resolve(result);
        },
        error: async (request, status, error) => {

        }
      })
    });
  }
}