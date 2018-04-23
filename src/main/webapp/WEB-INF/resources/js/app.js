$(function () {
  var ajax = new Ajax();
  var hotelsList = $('.hotelsList');

  function renderHotelList(endpoint) {
    ajax.ajaxGetCallback(endpoint, function (response) {
      // hotelsList.empty();
      var data = response.content;
      response.forEach(function (elem) {
        $('.hotelsList').append('<tr class="table-active">' +
        '<th scope="row">Active</th>' +
        '<td>' + elem.name + '</td>' +
        '<td>' + elem.description + '</td>' +
        '</tr>');
      })
    })
  }

  renderHotelList('/hotels');

});
