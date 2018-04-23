var Ajax = function () {
};

Ajax.prototype.ajaxGet = function (endpoint) {
    return $.getJSON({
        url: $(location).attr('origin') + endpoint,
        async: false
    })
};

Ajax.prototype.ajaxGetCallback = function (endpoint, callback) {
    this.ajaxGet(endpoint)
        .done(function (data) {
            callback(data);
        }).fail(function (xhr, status, error) {
        console.log(xhr, status, error);
    });
};

Ajax.prototype.ajaxPost = function (endpoint, data) {
    return $.post({
        headers: {
            'Content-Type': 'application/json'
        },
        url: $(location).attr('origin') + endpoint,
        data: JSON.stringify(data),
        async: false
    })
};

Ajax.prototype.ajaxPostCallback = function (endpoint, data, callback) {
    this.ajaxPost(endpoint, data)
        .done(function (data) {
            callback(data);
        }).fail(function (xhr, status, error) {
        console.log(xhr, status, error);
    });
};

Ajax.prototype.ajaxDelete = function (endpoint) {
    return $.ajax({
        url: $(location).attr('origin') + endpoint,
        type: 'DELETE',
        async: false
    })
};

Ajax.prototype.ajaxDeleteCallback = function (endpoint, callback) {
    this.ajaxDelete(endpoint)
        .done(function (data) {
            callback(data);
        }).fail(function (xhr, status, error) {
        console.log(xhr, status, error);
    });
};

Ajax.prototype.ajaxPut = function (endpoint, data) {
    return $.ajax({
        headers: {
            'Content-Type': 'application/json'
        },
        url: $(location).attr('origin') + endpoint,
        type: 'PUT',
        data: JSON.stringify(data),
        async: false
    })
};

Ajax.prototype.ajaxPutCallback = function (endpoint, data, callback) {
    this.ajaxPut(endpoint, data)
        .done(function (data) {
            callback(data);
        }).fail(function (xhr, status, error) {
        console.log(xhr, status, error);
    });
};
