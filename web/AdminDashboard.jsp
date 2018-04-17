<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- <meta name="description" content="Binary Pack">
    <meta name="author" content="Binary Pack Ltd.">-->
    <link rel="icon" href="img/favicon.ico">
    <title>Adminstator</title>

    <!-- CSS libraries-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Google fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">

    <!-- Custom stylesheet -->
    <link href="css/main.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                  <img src="data:image/jpeg;base64,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"
                       class="logo" alt="Logo"/>
                </a>
            </li>
            <li>
                <a href="#"><i class="fa fa-dashboard"></i> Dashboard</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-area-chart"></i> Analytics</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-tree"></i> Treading</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-shield"></i> Privacy</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-foursquare"></i> Forum</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-support"></i> Support</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-signal"></i> Settings</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <button href="#menu-toggle" class="wrapper_toggle_btn" id="menu-toggle">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="clearfix"></div>
        <!-- Header -->
        <div class="header">
            <!--<div class="clearfix"></div>-->
            <div class="row">
                <div class="col-lg-6 visible-lg visible-md">
                    <div class="search_bar">
                        <div class="input-group search_bar_input">
                            <span class="input-group-addon">
                                <button type="submit">
                                    <span class="fa fa-search"></span>
                                </button>
                            </span>
                            <input type="text" class="form-control"  placeholder="Search..." >
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="pull-left">
                        <input type="button" class="btn btn-group btn-group-justified bg-primary" value="Search"/>
                    </div>
                    <div class="pull-right">
                        <div class="profile-overview">
                            <div class="dropdown customm-dropdown">
                                <img src="img/profile.jpg" class="profile-pic" alt="Avatar"/>
                                <button class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Preview Techs
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                    <li><a href="#"><i class="fa fa-user"></i> Preview Techs</a></li>
                                    <li><a href="#"><i class="fa fa-wrench"></i> Setting</a></li>
                                    <li><a href="#"><i class="fa fa-power-off"></i> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--<div class="clearfix"></div>-->
                </div>
            </div>
        </div>
        <!-- /#header -->

        <!-- Content area -->
        <div class="container-fluid">
            <div class="content-area">
                <!-- content overview -->
                <div class="row">
                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <!--<div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-pie-chart"></i>
                                </div>
                            </div>-->
                            <div class="overview-right pull-left">
                                <h4 class="overview-value">$156060</h4>
                                <span class="overview-title">Total Revenue</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-bar-chart"></i>
                                </div>
                            </div>
                            <div class="overview-right pull-left">
                                <h4 class="overview-value">$156050</h4>
                                <span class="overview-title">Total Expense</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-bullhorn"></i>
                                </div>
                            </div>
                            <div class="overview-right pull-left">
                                <h4 class="overview-value">$1256</h4>
                                <span class="overview-title">Total Interest</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-briefcase"></i>
                                </div>
                            </div>
                            <div class="overview-right pull-left">
                                <h4 class="overview-value">$96652</h4>
                                <span class="overview-title">Total Balance</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Recent Visitor</h3>
                            </div>
                            <div class="panel-body">
                                <h3>RID displays your content in an eye-catching way and enables customizable internal distribution.</h3>
                                <h4>RID displays your content in an eye-catching way and enables customizable internal distribution.</h4>
                                <p>RID displays your content in an eye-catching way and enables customizable internal distribution. RID displays your content in an eye-catching way and enables customizable internal distribution.RID displays your content in an eye-catching way and enables customizable internal distribution.</p>
                            </div>
                        </div>
                        <!--<div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Recent Visitor</h3>
                            </div>
                            <div class="panel-body">
                                <h3>RID displays your content in an eye-catching way and enables customizable internal distribution.</h3>
                                <h4>RID displays your content in an eye-catching way and enables customizable internal distribution.</h4>
                                <p>RID displays your content in an eye-catching way and enables customizable internal distribution. RID displays your content in an eye-catching way and enables customizable internal distribution.RID displays your content in an eye-catching way and enables customizable internal distribution.</p>
                            </div>
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
        <!-- /#Content area -->

        <!-- Footer area -->
        <footer class="footer">
            <div class="container-fluid">
                <p class="copy-text">Copyright All Rights Reserved by Preview Technologies Limited © 2016</p>
            </div>
        </footer>
        <!-- /#Footer area -->
    </div>
    <!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->



<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>
<!-- Custom javascript -->
<script src="js/theme.js"></script>
</body>
</html>
