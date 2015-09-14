<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="donationUrl" value="/donation"/>
<style>
    .error {
        color: #ff0000;
    }
</style>


Donation page here

<table>
    <tr>
        <td>Amount:</td>
        <td><input id="amount" type="text"></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><input id="name" type="text" value="Andrea Lloyd"></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input id="email" type="text"></td>
    </tr>
    <tr>
        <td>Credit Card Number:</td>
        <td><input id="cc-number" type="text" value="4003830171874018"></td>
    </tr>
    <tr>
        <td>Expiration Month:</td>
        <td><input id="cc-month" type="text"></td>
    </tr>
    <tr>
        <td>Expiration Year:</td>
        <td><input id="cc-year" type="text" value="2016"></td>
    </tr>
    <tr>
        <td>CVV:</td>
        <td><input id="cc-cvv" type="text"></td>
    </tr>
    <tr>
        <td>Zipcode:</td>
        <td><input id="zip" type="text" value="94303"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" name="Submit" value="Submit" id="cc-submit"></td>
    </tr>
</table>

<script type="text/javascript" src="https://static.wepay.com/min/js/tokenization.v2.js"></script>
<script type="text/javascript">
    (function () {
        $.postJSON = function (url, data, callback) {
            return jQuery.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'type': 'POST',
                'url': url,
                'data': JSON.stringify(data),
                'dataType': 'json',
                'success': callback
            });
        };

        WePay.set_endpoint("stage"); // change to "production" when live

        // Shortcuts
        var d = document;
        d.id = d.getElementById,
                valueById = function (id) {
                    return d.id(id).value;
                };

        // For those not using DOM libraries
        var addEvent = function (e, v, f) {
            if (!!window.attachEvent) {
                e.attachEvent('on' + v, f);
            }
            else {
                e.addEventListener(v, f, false);
            }
        };

        // Attach the event to the DOM
        addEvent(d.id('cc-submit'), 'click', function () {
            var userName = [valueById('name')].join(' ');
            response = WePay.credit_card.create({
                "client_id": 87582,
                "user_name": valueById('name'),
                "email": valueById('email'),
                "cc_number": valueById('cc-number'),
                "cvv": valueById('cc-cvv'),
                "expiration_month": valueById('cc-month'),
                "expiration_year": valueById('cc-year'),
                "address": {
                    "zip": valueById('zip')
                }
            }, function (data) {
                if (data.error) {
                    console.log(data);
                    // handle error response
                } else {
                    // get the string from the input field for amount
                    // parse it a number

                    // call your own app's API to save the token inside the data;
                    var url = "${donationUrl}";
                    var postData = {creditCardId: data.credit_card_id, amount: 525.0};

                    $.postJSON(url, postData, function () {
                        console.log("got a result")
                    });

                    // show a success page
                }
            });
        });

    })();
</script>
