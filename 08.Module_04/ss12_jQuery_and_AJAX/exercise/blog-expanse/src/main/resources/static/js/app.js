// $(document).ready(function (){
// $("#btn1").click(function (){
//     alert("asdkjhasdjh");
// })
// });
function findByTitleName() {
    let titleName = $("#titleName").val();
    $.ajax({
        url: "/api/blog/search",
        data: {
            search: titleName
        },
        type: "get",
        dataType: "json",
        success: function (data) {
            let result = '';
            for (let i = 0; i < data.length; i++) {
                result += `
                    <a href="/blog/detail/${data[i].id}" class="text-decoration-none">
                        <h2>${data[i].title}</h2>
                    </a>
                    <p>${data[i].contentSummary}</p>
                    <p><span style="color: grey" th:text="*{#dates.format(datePublish, 'dd-MMM-yyyy')}"></span> by <span
                            style="font-weight: bold">${data[i].author}</span></p>
                    `;
            }
            $("#result").html(result);
        },
        error: function (e) {

        }
    });
}

function loadMore() {
    let count = $('#count').val();
    $(loadMoreHidden).hide();
    $.ajax({
        url: "/api/blog",
        type: "get",
        dataType: "json",
        success: function (data) {
            let result = '<div class="zone_content">';
            for (let i = count; i < data.length; i++) {
                result += `
                   <a href="/blog/detail/${data[i].id}" class="text-decoration-none">
                        <h2>${data[i].title}</h2>
                    </a>
                    <p>${data[i].contentSummary}</p>
                    <p><span style="color: grey" type="#dates.format('dd-MMM-yyyy')">${data[i].datePublish}</span> by <span
                            style="font-weight: bold">${data[i].author}</span></p>
                    <table>
                        <tr>
                            <td><a href="@{/blog/edit/${data[i].id}">
                                <button class="btn btn-warning">Edit</button>
                            </a></td>
                            <td>
                                <button class="btn btn-danger" data-bs-toggle="modal"
                                        attr="data-bs-target='#exampleModal'+${data[i].id}"
                                >
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </table>
                    <hr/>
                    <!-- Modal -->
                    <div class="modal fade"
                         attr="id='exampleModal'+${data[i].id}"
                         tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete Blog</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <span>Do you want remove </span><span style="color: red" th:text="*{title}"></span>
                                    <span>?</span>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <a href="@{/blog/delete/${data[i].id}">
                                        <button type="button" class="btn btn-primary">Delete</button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    `;
            }
            $("#loadMoreResult").html(result);
        },
        error: function (e) {
        }
    });
}

