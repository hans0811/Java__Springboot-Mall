<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pay</title>
</head>
<body>

    <div id="qrcodeCanvas"></div>
    <div id="orderId">${orderId}</div>
    <div id="returnUrl">${returnUrl}</div>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
    <script>
        jQuery('#qrcodeCanvas').qrcode({
            text : "${codeUrl}"
        });

        $(function () {
            //timer
            setInterval(function(){
                console.log('start payment status...');
                $.ajax({
                    url: '/pay/queryByOrderId',
                    data: {
                        'orderId' : $('#orderId').text()

                    },
                    success: function (result) {
                        console.log(result);

                        if (result.platformStatus != null && result.platformStatus === 'SUCCESS' ){
                            location.href = $("#returnUrl").text()
                        }
                    },
                    error: function (result) {
                        alert(result);
                    }
                })
            }, 2000)
        });

    </script>
</body>
</html>