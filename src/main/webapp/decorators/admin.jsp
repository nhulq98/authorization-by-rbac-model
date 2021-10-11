<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Dashboard - Ace Admin</title>

    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- Load Paging -->
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<%--        <script src="<c:url value="/template/paging/jquery.twbsPagination.js"/>" type="text/javascript"></script>--%>
    <!--========================-->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!-- bootstrap & fontawesome -->

    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/bootstrap.min.css"/>"/>

    <link rel="stylesheet"
          href="<c:url value="/template/admin/login/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->

    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/fonts.googleapis.com.css"/>"/>

    <!-- ace styles -->

    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace.min.css"/>"
          class="ace-main-stylesheet" id="main-ace-style"/>

    <!--[if lte IE 9]>

			<link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-part2.min.css"/>" class="ace-main-stylesheet" />
		<![endif]-->

    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-skins.min.css"/>"/>

    <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-rtl.min.css"/>"/>

    <!--[if lte IE 9]>
		  <link rel="stylesheet" href="<c:url value="/template/admin/login/assets/css/ace-ie.min.css"/>" />

		<![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="<c:url value="/template/admin/login/assets/js/ace-extra.min.js"/>"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
		<script src="<c:url value="/template/admin/login/assets/js/html5shiv.min.js"/>"></script>

		<script src="<c:url value="/template/admin/login/assets/js/respond.min.js"/>"></script>

		<![endif]-->

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>

</head>

<body class="no-skin">
<!-- HEADER-->
<%@include file="/common/admin/header.jsp" %>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

    <%@include file="/common/admin/sidebar.jsp" %>


    <div class="main-content">
        <dec:body/>
    </div><!-- /.main-content -->

    <%@include file="/common/admin/footer.jsp" %>

</div><!-- /.main-container -->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/template/admin/login/assets/js/jquery.mobile.custom.min.js"/>'>" + "<" + "/script>");
</script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
/*
this below Process of METHOD myNewFunction(sel)
* IDEA: when user select Role:
* case 1: if( Role exists in current Roles) ==> set action method: only Delete Role
* case 2: if( Role not exists in current Roles) ==> set action method: only ADD Role
* IDEA 2: When user select action method
* case 1: if action is Add ==> get value action current add new Role
* case 2: if action is Delete ==> delete Role current
* */
    // get value select option
    // get data list box: select roleCode
    function myNewFunction(sel) {
        //alert(sel.options[sel.selectedIndex].text);
        document.getElementById("roleCode").value = sel.options[sel.selectedIndex].text;

        //===============================get list roleCode from input========================================
        //get list code
        var rolesCode = document.getElementById("listOldRoleCode").value;

        //get code choiced
        var roleCode = document.getElementById("roleCode").value;

        // get action
        var action = document.getElementById("actionData").value;
        //=======================END 1==========================================

        //==================process find string into list . surpose: check exists or else================================
        //step1: split arr
        var listRoleCode = rolesCode.split(",");
        var check = true;// default: not exists Role code in list Roles

        //step2: duyet list roles
        for (i = 0; i < listRoleCode.length; i++) {
            if(listRoleCode[i].localeCompare(roleCode) == 0){// exist role in list role
                check = false; // exists
                // alert("arr before delete element: " + listRoleCode);

                //remove rolecode specifice
                // listRoleCode.splice(i, 1);

                // alert("arr after delete element: " + listRoleCode);
            }
        }

        // reload select option current
        document.getElementById("actionSelect").selectedIndex = 0;

        //show all select option
        document.getElementById("delete").style.display = "block";
        document.getElementById("add").style.display = "block";

        //step 3: check condition
        if(check == true){// not exists role in list Roles
            alert("not exists");

            // hidden action DELETE. only ADD
            document.getElementById("delete").style.display = "none";

            //add roleCode into arr
            listRoleCode.push(roleCode);

            // load arr and CONCAT all elements
            var roleCodeUpdated = "";
            for(i = 0; i < listRoleCode.length; i++){
                // alert("concat element " + i +": " + listRoleCode[i])
                roleCodeUpdated = roleCodeUpdated + listRoleCode[i];
                // alert("String after concat data from array: " + roleCodeUpdated);
                if(listRoleCode[i] != ""){// check use case
                    roleCodeUpdated += ",";
                }

            }
            // alert("String after concat data from array: " + roleCodeUpdated);

            // change data
            document.getElementById("roleUpdate").value = roleCodeUpdated;
            document.getElementById("roleCode").value = roleCodeUpdated;


            // var x = document.getElementById("delete");
            // x.remove(x.selectedIndex);
            // document.getElementById("add")

        }else{// exists role in list Roles ==> DELETE role and UPDATE current Roles and HIDDEN action ADD
                alert("exists!!");

            // DELETE element exists
            for(i = 0; i < listRoleCode.length; i++){
                if(listRoleCode[i].localeCompare(roleCode) == 0){// exist role in list role
                    // alert("arr before delete element: " + listRoleCode);

                    //remove rolecode specifice
                    listRoleCode.splice(i, 1);

                    // alert("arr after delete element: " + listRoleCode);
                }
            }

            // UPDATE data
            //b1: concat elements to string
            var roleCodeUpdated = "";
            for(i = 0; i < listRoleCode.length; i++){
                // alert("concat element " + i +": " + listRoleCode[i])
                roleCodeUpdated = roleCodeUpdated + listRoleCode[i];
                // alert("String after concat data from array: " + roleCodeUpdated);
                if(listRoleCode[i] != ""){ // check USE CASE if arr != empty:==> can add ','  ==> no bug
                    roleCodeUpdated += ",";
                }

            }
            //b2: update data
            document.getElementById("roleUpdate").value = roleCodeUpdated;
            document.getElementById("roleCode").value = roleCodeUpdated;
            //===================================================================

            // HIDDEN action ADD. only DELETE
            document.getElementById("add").style.display = "none";
        }

        //alert(rolesCode);
        //alert(roleCode);
        // alert(action);
    }
    // get data list box: select Action
    function myNewFunction4(sel) {
        document.getElementById("actionData").value = sel.options[sel.selectedIndex].text;

    }

    function myNewFunction3(sel) {
        //get list roleCode from input
        var rolesCode = document.getElementById("listRoleCode").value;
        var roleCode = document.getElementById("roleCode").value;
        var action = document.getElementById("actionData").value;

    }

    jQuery(function ($) {
        $('.easy-pie-chart.percentage').each(function () {
            var $box = $(this).closest('.infobox');
            var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
            var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
            var size = parseInt($(this).data('size')) || 50;
            $(this).easyPieChart({
                barColor: barColor,
                trackColor: trackColor,
                scaleColor: false,
                lineCap: 'butt',
                lineWidth: parseInt(size / 10),
                animate: ace.vars['old_ie'] ? false : 1000,
                size: size
            });
        });

        $('.sparkline').each(function () {
            var $box = $(this).closest('.infobox');
            var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
            $(this).sparkline('html',
                {
                    tagValuesAttribute: 'data-values',
                    type: 'bar',
                    barColor: barColor,
                    chartRangeMin: $(this).data('min') || 0
                });
        });


        //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
        //but sometimes it brings up errors with normal resize event handlers
        $.resize.throttleWindow = false;

        var placeholder = $('#piechart-placeholder').css({'width': '90%', 'min-height': '150px'});
        var data = [
            {label: "social networks", data: 38.7, color: "#68BC31"},
            {label: "search engines", data: 24.5, color: "#2091CF"},
            {label: "ad campaigns", data: 8.2, color: "#AF4E96"},
            {label: "direct traffic", data: 18.6, color: "#DA5430"},
            {label: "other", data: 10, color: "#FEE074"}
        ];

        function drawPieChart(placeholder, data, position) {
            $.plot(placeholder, data, {
                series: {
                    pie: {
                        show: true,
                        tilt: 0.8,
                        highlight: {
                            opacity: 0.25
                        },
                        stroke: {
                            color: '#fff',
                            width: 2
                        },
                        startAngle: 2
                    }
                },
                legend: {
                    show: true,
                    position: position || "ne",
                    labelBoxBorderColor: null,
                    margin: [-30, 15]
                }
                ,
                grid: {
                    hoverable: true,
                    clickable: true
                }
            })
        }

        drawPieChart(placeholder, data);

        /**
         we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
         so that's not needed actually.
         */
        placeholder.data('chart', data);
        placeholder.data('draw', drawPieChart);


        //pie chart tooltip example
        var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
        var previousPoint = null;

        placeholder.on('plothover', function (event, pos, item) {
            if (item) {
                if (previousPoint != item.seriesIndex) {
                    previousPoint = item.seriesIndex;
                    var tip = item.series['label'] + " : " + item.series['percent'] + '%';
                    $tooltip.show().children(0).text(tip);
                }
                $tooltip.css({top: pos.pageY + 10, left: pos.pageX + 10});
            } else {
                $tooltip.hide();
                previousPoint = null;
            }

        });

        /////////////////////////////////////
        $(document).one('ajaxloadstart.page', function (e) {
            $tooltip.remove();
        });


        var d1 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.5) {
            d1.push([i, Math.sin(i)]);
        }

        var d2 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.5) {
            d2.push([i, Math.cos(i)]);
        }

        var d3 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.2) {
            d3.push([i, Math.tan(i)]);
        }


        var sales_charts = $('#sales-charts').css({'width': '100%', 'height': '220px'});
        $.plot("#sales-charts", [
            {label: "Domains", data: d1},
            {label: "Hosting", data: d2},
            {label: "Services", data: d3}
        ], {
            hoverable: true,
            shadowSize: 0,
            series: {
                lines: {show: true},
                points: {show: true}
            },
            xaxis: {
                tickLength: 0
            },
            yaxis: {
                ticks: 10,
                min: -2,
                max: 2,
                tickDecimals: 3
            },
            grid: {
                backgroundColor: {colors: ["#fff", "#fff"]},
                borderWidth: 1,
                borderColor: '#555'
            }
        });


        $('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('.tab-content');
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }


        $('.dialogs,.comments').ace_scroll({
            size: 300
        });


        //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
        //so disable dragging when clicking on label
        var agent = navigator.userAgent.toLowerCase();
        if (ace.vars['touch'] && ace.vars['android']) {
            $('#tasks').on('touchstart', function (e) {
                var li = $(e.target).closest('#tasks li');
                if (li.length == 0) return;
                var label = li.find('label.inline').get(0);
                if (label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation();
            });
        }

        $('#tasks').sortable({
                opacity: 0.8,
                revert: true,
                forceHelperSize: true,
                placeholder: 'draggable-placeholder',
                forcePlaceholderSize: true,
                tolerance: 'pointer',
                stop: function (event, ui) {
                    //just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                    $(ui.item).css('z-index', 'auto');
                }
            }
        );
        $('#tasks').disableSelection();
        $('#tasks input:checkbox').removeAttr('checked').on('click', function () {
            if (this.checked) $(this).closest('li').addClass('selected');
            else $(this).closest('li').removeClass('selected');
        });


        //show the dropdowns on top or bottom depending on window height and menu position
        $('#task-tab .dropdown-hover').on('mouseenter', function (e) {
            var offset = $(this).offset();

            var $w = $(window);
            if (offset.top > $w.scrollTop() + $w.innerHeight() - 100)
                $(this).addClass('dropup');
            else $(this).removeClass('dropup');
        });

    })

</script>

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="<c:url value="/template/admin/login/assets/js/jquery-2.1.4.min.js"/>"></script>

<%--    <!--[if IE]>--%>
<script src="<c:url value="/template/admin/login/assets/js/jquery-1.11.3.min.js"/>"></script>

<%--    <![endif]-->--%>

<script src="<c:url value="/template/admin/login/assets/js/bootstrap.min.js"/>"></script>

<script src="<c:url value="/template/admin/login/assets/js/excanvas.min.js"/>"></script>

<!-- <![endif]-->

<%--    <![endif]-->--%>


<script src="<c:url value="/template/admin/login/assets/js/jquery.flot.resize.min.js"/>"></script>

<%--    <!-- ace scripts -->--%>
<script src="<c:url value="/template/admin/login/assets/js/ace-elements.min.js"/>"></script>

<script src="<c:url value="/template/admin/login/assets/js/ace.min.js"/>"></script>


</body>
</html>
