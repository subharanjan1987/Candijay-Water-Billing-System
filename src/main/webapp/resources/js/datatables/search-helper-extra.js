var barangayFilters=["Cogtong", "Tawid", "Can-olin", "Cadapdapan", "Tambongan",
    "Abihilan", "La Union", "Panadtaran", "Poblacion", "Boyoan", "Pagahat"];
var purokFilters=[1,2,3,4,5,6,7];
yadcf.init(oTable_account, [
    {
        "externally_triggered": true,
        "filter_type": "text",
        "filter_container_id": "acct-no",
        "column_number": 0,
        "filter_reset_button_text": '<i class="fa fa-remove fa-fw"></i>'
    },{
        "externally_triggered": true,
        "filter_type": "text",
        "filter_container_id": "acct-lastname",
        "column_number": 1,
        "filter_reset_button_text": '<i class="fa fa-remove fa-fw"></i>'
    },{
        "externally_triggered": true,
        "filter_type": "text",
        "filter_container_id": "acct-firstname",
        "column_number": 2,
        "filter_reset_button_text": '<i class="fa fa-remove fa-fw"></i>'
    },{
        "externally_triggered": true,
        "data": barangayFilters,
        "filter_type": "select",
        "filter_container_id": "acct-brgy",
        "column_number": 3,
        "filter_reset_button_text": '<i class="fa fa-remove fa-fw"></i>'
    },{
        "externally_triggered": true,
        "data": purokFilters,
        "filter_type": "select",
        "filter_container_id": "acct-zone",
        "column_number": 4,
        "sort_as": "numerical",
        "filter_reset_button_text": '<i class="fa fa-remove fa-fw"></i>'
    }], 'none');