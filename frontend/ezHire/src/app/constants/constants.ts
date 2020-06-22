export abstract class Constants {
    static baseUrl = "http://localhost:8080"
    static Urls = {
        'fetchJobs': '/admin/job',
        'postJob':'/admin/job',
        'fetchStatuses': '/admin/job/candidates',
        'fetchResume':'/user/resume/fetch/:userId',
        'saveResume':'/user/resume/submit/:userId',
        'submitResumeForJob': '/user/job/:jobId/:userId',
        'fetchAppliedJobs':'/user/job/fetch/:userId'
    }

}
