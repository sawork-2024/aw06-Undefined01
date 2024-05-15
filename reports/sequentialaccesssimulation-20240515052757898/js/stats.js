var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "200",
        "ok": "155",
        "ko": "45"
    },
    "minResponseTime": {
        "total": "6",
        "ok": "6",
        "ko": "1001"
    },
    "maxResponseTime": {
        "total": "1129",
        "ok": "1129",
        "ko": "1005"
    },
    "meanResponseTime": {
        "total": "420",
        "ok": "251",
        "ko": "1003"
    },
    "standardDeviation": {
        "total": "413",
        "ok": "305",
        "ko": "1"
    },
    "percentiles1": {
        "total": "119",
        "ok": "114",
        "ko": "1003"
    },
    "percentiles2": {
        "total": "993",
        "ok": "335",
        "ko": "1004"
    },
    "percentiles3": {
        "total": "1004",
        "ok": "962",
        "ko": "1004"
    },
    "percentiles4": {
        "total": "1010",
        "ok": "1031",
        "ko": "1005"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 137,
    "percentage": 69
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 18,
    "percentage": 9
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 45,
    "percentage": 23
},
    "meanNumberOfRequestsPerSecond": {
        "total": "40",
        "ok": "31",
        "ko": "9"
    }
},
contents: {
"req_request--produc--1902203791": {
        type: "REQUEST",
        name: "Request /product",
path: "Request /product",
pathFormatted: "req_request--produc--1902203791",
stats: {
    "name": "Request /product",
    "numberOfRequests": {
        "total": "100",
        "ok": "100",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "16",
        "ok": "16",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "125",
        "ok": "125",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "90",
        "ok": "90",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "32",
        "ok": "32",
        "ko": "-"
    },
    "percentiles1": {
        "total": "110",
        "ok": "110",
        "ko": "-"
    },
    "percentiles2": {
        "total": "117",
        "ok": "117",
        "ko": "-"
    },
    "percentiles3": {
        "total": "121",
        "ok": "121",
        "ko": "-"
    },
    "percentiles4": {
        "total": "124",
        "ok": "124",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 100,
    "percentage": 100
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "20",
        "ok": "20",
        "ko": "-"
    }
}
    },"req_request--cart-678140638": {
        type: "REQUEST",
        name: "Request /cart",
path: "Request /cart",
pathFormatted: "req_request--cart-678140638",
stats: {
    "name": "Request /cart",
    "numberOfRequests": {
        "total": "100",
        "ok": "55",
        "ko": "45"
    },
    "minResponseTime": {
        "total": "6",
        "ok": "6",
        "ko": "1001"
    },
    "maxResponseTime": {
        "total": "1129",
        "ok": "1129",
        "ko": "1005"
    },
    "meanResponseTime": {
        "total": "750",
        "ok": "543",
        "ko": "1003"
    },
    "standardDeviation": {
        "total": "350",
        "ok": "357",
        "ko": "1"
    },
    "percentiles1": {
        "total": "993",
        "ok": "552",
        "ko": "1003"
    },
    "percentiles2": {
        "total": "1003",
        "ok": "884",
        "ko": "1004"
    },
    "percentiles3": {
        "total": "1004",
        "ok": "999",
        "ko": "1004"
    },
    "percentiles4": {
        "total": "1056",
        "ok": "1089",
        "ko": "1005"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 37,
    "percentage": 37
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 18,
    "percentage": 18
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 45,
    "percentage": 45
},
    "meanNumberOfRequestsPerSecond": {
        "total": "20",
        "ok": "11",
        "ko": "9"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
