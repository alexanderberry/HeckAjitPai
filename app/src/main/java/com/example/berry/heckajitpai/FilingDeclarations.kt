package com.example.berry.heckajitpai

/**
 * Created by per6 on 1/23/18.
 */
data class Filings(
        val filings: List<Filing>,
		val aggregations: Aggregations
)

data class Aggregations(
		val express_comment: ExpressComment,
		val bureaus_description: BureausDescription,
		val submissiontype_description: SubmissiontypeDescription,
		val exparte_or_late_filed: ExparteOrLateFiled,
		val is_staff_upload: IsStaffUpload,
		val proceedings_name: ProceedingsName,
		val filingstatus_description: FilingstatusDescription,
		val filers_name: FilersName,
		val authors_name: AuthorsName,
		val viewingstatus_description: ViewingstatusDescription
)

data class ExpressComment(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Bucket>
)

data class Bucket(
		val key: Int, //1
		val doc_count: Int //20
)

data class FilingstatusDescription(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Bucket>
)

data class AuthorsName(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Any>
)

data class SubmissiontypeDescription(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Bucket>
)

data class ViewingstatusDescription(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Bucket>
)

data class FilersName(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Bucket>
)

data class BureausDescription(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Any>
)

data class ExparteOrLateFiled(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Any>
)

data class ProceedingsName(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Bucket>
)

data class IsStaffUpload(
		val doc_count_error_upper_bound: Int, //0
		val sum_other_doc_count: Int, //0
		val buckets: List<Any>
)

data class Filing(
		val confirmation_number: String, //201706033037724585
		val submissiontype: Submissiontype,
		val documents: List<Any>,
		val bureaus: List<Any>,
		val id_submission: String, //10603711209649
		val lawfirms: List<Any>,
		val viewingstatus: Viewingstatus,
		val contact_email: String, //markberry0054@gmail.com
		val express_comment: Int, //1
		val internationaladdressentity: Internationaladdressentity,
		val addressentity: Addressentity,
		val filers: List<Filer>,
		val date_submission: String, //2017-05-23T22:08:27+00:00
		val date_disseminated: String, //2017-06-03T02:05:16.000Z
		val filingstatus: Filingstatus,
		val proceedings: List<Proceeding>,
		val presented_to: List<Any>,
		val date_received: String, //2017-05-23T22:08:27+00:00
		val text_data: String, //To the FCC:  I'm a voter worried about an open Internet. I suggest you to rescind The Obama/Wheeler plan to take over the Internet. Individuals, not so-called experts, should be empowered to enjoy which products we desire. The Obama/Wheeler plan to take over the Internet is a distortion of net neutrality. It disrupted a hands-off policy that worked fabulously smoothly for many years with broad bipartisan support.
		val authors: List<Any>,
		val highlight: Highlight,
		val _index: String //filings.2017.5
)

data class Submissiontype(
		val short: String, //COMMENT
		val description: String, //COMMENT
		val id: Int, //7
		val abbreviation: String //CO
)

data class Viewingstatus(
		val description: String, //Sunshine
		val id: String //40
)

data class Internationaladdressentity(
		val addresstext: String
)

data class Filer(
		val name: String //Mark Berry
)

data class Filingstatus(
		val description: String, //DISSEMINATED
		val id: Int //30
)

data class Proceeding(
		val id_proceeding: String, //301759
		val name: String, //17-108
		val description: String //Restoring Internet Freedom
)

data class Addressentity(
		val city: String, //Denton
		val address_line_1: String, //1736 Glancy Frk
		val zip4: String,
		val state: String, //KY
		val address_line_2: String,
		val zip_code: String //41132
)

data class Highlight(
		val text_data: List<String>
)
