var main = {
    init : function() {
        let _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-update').on('click', function() {
            _this.update();
        });

        $('#btn-delete').on('click', function() {
            _this.delete();
        });
    },

    save : function() {
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'post',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert("글 등록 완료");
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    update: function() {
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        let id = $('#id').val();

        $.ajax({
           type: 'put',
           url: '/api/v1/posts/' + id,
           dataType: 'json',
           contentType: 'application/json; charset=utf-8',
           data: JSON.stringify(data)
        }).done(function() {
            alert("글 수정 완료");
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error))
        });
    },

    delete: function() {
        let id = $('#id').val();

        $.ajax({
           type: 'delete',
           url: '/api/v1/posts/' + id,
           dataType: 'json',
           contentType: 'application/json; charset=utf-8',
        }).done(function() {
           alert("글 삭제 완료");
           window.location.href = '/';
        }).fail(function(error) {
           alert(JSON.stringify(error));
        });
    }

};
main.init();